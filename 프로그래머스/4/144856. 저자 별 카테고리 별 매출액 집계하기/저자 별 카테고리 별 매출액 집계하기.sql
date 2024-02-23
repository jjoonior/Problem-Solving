-- 코드를 입력하세요
SELECT a.author_id, author_name, category, sum(total_sales) as total_sales
from author a
join 
(
    select author_id, a.book_id, category, sum(price * sales) as total_sales
    from book a
    join book_sales b on a.book_id = b.book_id
    where year(sales_date) = 2022 and month(sales_date) = 1
    group by a.book_id
) b
on a.author_id = b.author_id
group by a.author_id, category
order by a.author_id, category desc