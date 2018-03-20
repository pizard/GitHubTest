# paging
 - index 넘버링
	```
	SELECT
		@ROWNUM:=@ROWNUM+1 as number
		, NUMBERING.*
	FROM (
		SELECT
			B.board_sq
			, B.board_title
			, B.category
		    , CD.cd_detail_nm as category_nm
			, B.del_yn
			, B.open
			,(case open when 'Y' then '공개' 
				when 'N' then '비공개'
				else 'error' end) as open_nm
			, B.rgsde
			, DATE_FORMAT(B.rgsde, '%Y-%m-%d') as rgsde_nm
		FROM 
			3DP_BOARD B 
				LEFT OUTER JOIN 3DP_CODE_DETAIL CD ON B.CATEGORY = CD.CD_DETAIL_NO 
				INNER JOIN 3DP_CODE C ON C.CD_NO = CD.CD_NO AND C.CD_NM='문의하기'
				, (SELECT @ROWNUM:=${start})TMP
		WHERE 
			B.DEL_YN = 'N'
			AND CD.DEL_YN = 'N'
			AND C.DEL_YN = 'N'
			AND B.BOARD_DV = #{board_dv }
			<include refid="searchForm" />
			ORDER BY B.RGSDE DESC
			LIMIT ${start}, ${pageSize}
	) AS NUMBERING
	```

 - 최적화
 ```
 SELECT
			B.board_sq
			, B.board_title
			, B.category
	    	, CD.cd_detail_nm as category_nm
			, B.del_yn
			, B.open
		    ,(case open when 'Y' then '공개' 
		    			when 'N' then '비공개'
		    			else 'error' end) as open_nm
			, B.rgsde
			, DATE_FORMAT(B.rgsde, '%Y-%m-%d') as rgsde_nm
		FROM 
			3DP_BOARD B LEFT OUTER JOIN 
				3DP_CODE_DETAIL CD ON B.CATEGORY = CD.CD_DETAIL_NO 
				INNER JOIN 3DP_CODE C ON C.CD_NO = CD.CD_NO AND C.CD_NM='문의하기'
		WHERE 
			B.DEL_YN = 'N'
			AND CD.DEL_YN = 'N'
			AND C.DEL_YN = 'N'
			AND B.BOARD_DV = #{board_dv }
		    <include refid="searchForm" />
		ORDER BY B.RGSDE DESC
		LIMIT ${start}, ${pageSize}
		```