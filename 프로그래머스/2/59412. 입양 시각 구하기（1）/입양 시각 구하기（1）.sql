-- 코드를 입력하세요
SELECT hour(datetime) as hour, count(*) as count
from animal_outs
where hour(datetime) between 9 and 20
group by hour
order by hour asc;