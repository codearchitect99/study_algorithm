-- 코드를 입력하세요
SELECT substring(product_code from 1 for 2) as category, count(*) as products
from product
group by substring(product_code from 1 for 2)
order by category asc;
