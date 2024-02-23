-- 코드를 입력하세요
SELECT year(sales_date) as year, month(sales_date) as month, gender, count(distinct b.user_id) as users
from online_sale a
join user_info b on a.user_id = b.user_id
where gender is not null
group by year, month, gender
order by year, month, gender