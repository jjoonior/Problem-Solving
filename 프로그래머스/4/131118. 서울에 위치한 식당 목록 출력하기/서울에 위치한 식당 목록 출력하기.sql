-- 코드를 입력하세요
SELECT i.REST_ID,	REST_NAME,	FOOD_TYPE,	FAVORITES, ADDRESS,	round(avg(REVIEW_SCORE), 2) as score
from rest_info i
join rest_review  r on i.rest_id = r.rest_id
where address like '서울%'
group by rest_id
# having address like '서울%'
order by score desc, favorites desc

