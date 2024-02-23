-- 코드를 입력하세요
set @hour = 8;

SELECT 
    (@hour := @hour + 1) as hour, 
    (select count(*) from animal_outs where hour(datetime) = @hour) as count
from animal_outs
where @hour < 19

