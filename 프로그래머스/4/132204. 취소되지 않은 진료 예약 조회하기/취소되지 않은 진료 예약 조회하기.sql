-- 코드를 입력하세요 진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시 
SELECT APNT_NO, PT_NAME, a.PT_NO, a.MCDP_CD, DR_NAME, APNT_YMD
from appointment a
join patient b on a.pt_no = b.pt_no
join doctor c on a.mddr_id = c.dr_id
where APNT_YMD like '2022-04-13%' and apnt_cncl_yn = 'N' and a.mcdp_cd = 'CS'
order by APNT_YMD



