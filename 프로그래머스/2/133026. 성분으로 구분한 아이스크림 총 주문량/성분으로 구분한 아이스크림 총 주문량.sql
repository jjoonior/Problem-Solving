-- 코드를 입력하세요
SELECT INGREDIENT_TYPE,	sum(total_order) as TOTAL_ORDER
from first_half a
join icecream_info b on a.flavor = b.flavor
group by INGREDIENT_TYPE
order by total_order

