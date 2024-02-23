-- 코드를 입력하세요
SELECT distinct a.car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY a
join CAR_RENTAL_COMPANY_car b on a.car_id = b.car_id
where b.car_type = '세단' and month(a.start_date) =10
order by car_id desc