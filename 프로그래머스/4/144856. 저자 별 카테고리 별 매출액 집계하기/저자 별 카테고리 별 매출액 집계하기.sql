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


# SELECT T2.AUTHOR_ID, T1.AUTHOR_NAME, T2.CATEGORY, SUM(T2.TOTAL_SALES) AS TOTAL_SALES
# FROM AUTHOR T1
# INNER JOIN 
# (
#     SELECT B.AUTHOR_ID, B.CATEGORY, (B.PRICE * S.SALES) AS TOTAL_SALES -- 1월 도서 판매별 매출액
#     FROM BOOK_SALES S
#     INNER JOIN BOOK B
#         ON B.BOOK_ID = S.BOOK_ID
#     WHERE S.SALES_DATE LIKE '2022-01%'
# ) T2
#     ON T1.AUTHOR_ID = T2.AUTHOR_ID
# GROUP BY T2.AUTHOR_ID, T1.AUTHOR_NAME, T2.CATEGORY
# ORDER BY T2.AUTHOR_ID, T2.CATEGORY DESC;