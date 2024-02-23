-- 코드를 입력하세요
select a.car_id, average_duration
from CAR_RENTAL_COMPANY_RENTAL_HISTORY a
join (
SELECT car_id, round(avg(datediff(end_date, start_date) + 1),1) as average_duration
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
) b on a.car_id = b.car_id
where b.average_duration >=7
group by a.car_id
order by average_duration desc, a.car_id desc


