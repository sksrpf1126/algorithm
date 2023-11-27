-- 조건에 맞는 사용자와 총 거래금액 조회하기 --
SELECT gu.user_id, gu.nickname, gb.total_sales
FROM
(
    SELECT writer_id, sum(price) as total_sales
    FROM used_goods_board
    WHERE status = 'DONE'
    GROUP BY writer_id
    HAVING SUM(price) >= 700000
) gb
INNER JOIN
used_goods_user gu
ON gb.writer_id = gu.user_id
ORDER BY gb.total_sales;

-- 즐겨찾기가 가장 많은 식당 정보 출력하기 --
SELECT ri.food_type, ri.rest_id, ri.rest_name, ri.favorites
FROM (
    SELECT food_type, rest_id, rest_name, favorites, RANK() OVER(PARTITION BY food_type ORDER BY FAVORITES desc) as rnk
    FROM rest_info
) as ri
where ri.rnk = 1
ORDER BY ri.food_type desc;

-- 저자 별 카테고리 별 매출액 집계하기 --
SELECT b.author_id, a.author_name, b.category, sum(bs.cnt * b.price) as total_sales
FROM
(
    SELECT book_id, SUM(sales) as cnt
    FROM book_sales
    WHERE DATE_FORMAT(sales_date, '%Y-%m') = '2022-01'
    GROUP BY book_id
) as bs
INNER JOIN book b
ON bs.book_id = b.book_id
INNER JOIN author a
ON b.author_id = a.author_id
GROUP BY b.author_id, a.author_name, b.category
ORDER BY a.author_id, b.category desc;

-- 식품분류별 가장 비싼 식품의 정보 조회하기 --
SELECT category, price as max_price, product_name
FROM
(
    SELECT category, price, product_name, rank() over(partition by category order by price desc) as rnk
    FROM food_product
    WHERE category IN ('과자', '국', '김치', '식용유')
) as A
WHERE rnk = 1
ORDER BY max_price desc;