import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TF_IDF extends Configured implements Tool {

    public  static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new TF_IDF(), args);
        System.exit(res);
    }

    String TermFreqPath = "TermFreqPath/";
    String TermIDFPath = "TermIDFPath/";


    public int run(String[] args) throws Exception {
        // get |D| : Num of Document + 1 for infinite case
        FileSystem file = FileSystem.get(conf);
        FileStatus[] liststat = file.listStatus(new Path(args[0]));
        conf.setInt("N",liststat.length+1);

        /* ----------------------  job 1 : Get frequence of word in document ---------------------- */

        Job job_1 = new Job(conf,"Get frequence of word");

        job_1.setJarByClass(this.getClass());
        job_1.setMapperClass(Freq_Mapper.class);
        job_1.setReducerClass(Freq_Reducer.class);

        job_1.setOutputKeyClass(Text.class);
        job_1.setOutputValueClass(IntWritable.class);

        // JoonLib.removeAllFile(TermFreqPath); // remove exist output folder

        FileInputFormat.addInputPath(job_1,new Path(args[0]));
        FileOutputFormat.setOutputPath(job_1, new Path(TermFreqPath));

        job_1.waitForCompletion(true);


        /* ----------------------  job 2 : Get IDF ---------------------- */

        Job job_2 = new Job(conf,"Get IDF");

        job_2.setJarByClass(this.getClass());
        job_2.setMapperClass(IDF_Mapper.class);
        job_2.setReducerClass(IDF_Reducer.class);

        job_2.setOutputKeyClass(Text.class);
        job_2.setOutputValueClass(Text.class);

        // JoonLib.removeAllFile(TermIDFPath); // remove exist output folder

        FileInputFormat.addInputPath(job_2,new Path(TermFreqPath));
        FileOutputFormat.setOutputPath(job_2, new Path(TermIDFPath));

        job_2.waitForCompletion(true);


        /* ----------------------  job 3 : Get TF_IDF ---------------------- */

        Job job_3 = new Job(conf,"Get TF_IDF");

        job_3.setJarByClass(this.getClass());
        job_3.setMapperClass(TF_IDF_Mapper.class);
        job_3.setReducerClass(TF_IDF_Reducer.class);

        job_3.setOutputKeyClass(Text.class);
        job_3.setOutputValueClass(Text.class);

        // JoonLib.removeAllFile(args[1]); // remove exist output folder

        FileInputFormat.addInputPath(job_3, new Path(TermIDFPath));
        FileOutputFormat.setOutputPath(job_3, new Path(args[1]));

        returnCode = job_3.waitForCompletion(true);

        // JoonLib.removeAllFile(TermFreqPath); // remove exist temp folder
        // JoonLib.removeAllFile(TermIDFPath);  // remove exist temp folder

        return returnCode ? 0 : 1;
    }



    public static class Freq_Mapper extends Mapper<LongWritable,Text,Text,IntWritable> {
        private static final Pattern PATTERN = Pattern.compile("\\w+");
        public static final IntWritable one = new IntWritable(1);

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            FileSplit split = (FileSplit) context.getInputSplit();
            String DOC_Name = split.getPath().getName();

            Matcher matcher = PATTERN.matcher(value.toString());
            while (matcher.find()){
                String word = matcher.group().toLowerCase();
                context.write(new Text(word+" "+DOC_Name),one);
            }
        }
    }
    public static class Freq_Reducer extends Reducer<Text,IntWritable, Text, IntWritable> {
        private IntWritable intWritable = new IntWritable();

        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int total = 0;
            for(IntWritable text : values){
                total += text.get();
            }
            intWritable.set(total);
            context.write(key,intWritable);
        }
    }


    public static class IDF_Mapper extends Mapper<LongWritable, Text, Text, Text>{
        public static final IntWritable one = new IntWritable(1);

        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] fre_input = value.toString().split("\\s+");
            String term = fre_input[0];
            String DOC_Name = fre_input[1];

            int frequence = Integer.parseInt(fre_input[2]);

            context.write(new Text(term),new Text(DOC_Name+ " "+frequence));
        }
    }
    public static class IDF_Reducer extends Reducer<Text,Text,Text,Text> {

        @Override
        public void reduce(Text key, Iterable<Text> values, final Context context) throws IOException, InterruptedException {
            Map<Text,String> count = new HashMap<Text, String>();
            int total = 1;

            for (Text word : values){
                String[] DOC_Name_tf = word.toString().split("\\s+");
                String DOC_Name = DOC_Name_tf[0];
                String tf_value = DOC_Name_tf[1];

                count.put(new Text(key.toString()+" "+DOC_Name),tf_value);
                total ++;
            }

            for (Text DOC_Name : count.keySet()){
                String tf = count.get(DOC_Name);
                context.write(DOC_Name,new Text(tf+" "+total));
            }
        }
    }




    public static class TF_IDF_Mapper extends Mapper<LongWritable, Text, Text, Text>{
        private static long N;

        @Override
        protected void setup(Context context) throws IOException, InterruptedException {
            Configuration conf = context.getConfiguration();
            N = conf.getLong("N",1);
        }

        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] field = value.toString().split("\\s+");
            String text = field[0];
            String DOC_Name = field[1];
            int TF = Integer.parseInt(field[2]);
            double n = Integer.parseInt(field[3]);

            double temp = N/n;
            double IDF = Math.log(temp);
            double TF_IDF = TF * IDF;


            context.write(new Text(String.format("%15s | %10s |   tf-idf : ", text, DOC_Name)),new Text(String.valueOf(TF_IDF)));
        }
    }

    public static class TF_IDF_Reducer extends Reducer<Text,Text,Text,Text> {
        @Override
        public void reduce(Text key, Iterable<Text> values, final Context context) throws IOException, InterruptedException {
            for (Text word : values){
                context.write(key,word);
            }
        }
    }
}
