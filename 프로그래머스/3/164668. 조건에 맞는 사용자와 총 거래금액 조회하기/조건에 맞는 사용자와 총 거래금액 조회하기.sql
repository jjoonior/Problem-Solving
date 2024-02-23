-- 코드를 입력하세요
SELECT user_id, nickname, sum(price) as total_sales
from used_goods_user a
join used_goods_board b on a.user_id = b.writer_id
where b.status = 'Done'
group by writer_id
having total_sales >= 700000
order by total_sales 
