-- 코드를 입력하세요
SELECT history_id, 
    car_id, 
    date_format(start_date, '%Y-%m-%d') as start_date, 
    date_format(end_date, '%Y-%m-%d') as end_date, 
    case when datediff(end_date,start_date) >= 29 
    then '장기 대여' 
    else '단기 대여' 
    end rent_type
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date like '2022-09%'
order by history_id desc


# SELECT HISTORY_ID, CAR_ID, 
# 	   DATE_FORMAT (START_DATE, "%Y-%m-%d") AS START_DATE, 
# 	   DATE_FORMAT (END_DATE, "%Y-%m-%d") AS END_DATE,
# CASE WHEN DATEDIFF(END_DATE, START_DATE) < 29 then '단기 대여' 
#             ELSE '장기 대여' 
#             END AS  RENT_TYPE
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE START_DATE LIKE '2022-09-%'
# ORDER BY HISTORY_ID DESC;