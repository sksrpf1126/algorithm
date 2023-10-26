-- 3월에 태어난 여성 회원 목록 출력하기 --
SELECT member_id, member_name, gender, DATE_FORMAT(date_of_birth, '%Y-%m-%d') as date_of_birth
FROM member_profile
WHERE MONTH(date_of_birth) = 3 and gender = 'W' and tlno IS NOT NULL
ORDER BY member_id;


-- 재구매가 일어난 상품과 회원 리스트 구하기 --
SELECT user_id, product_id
FROM online_sale
GROUP BY user_id, product_id
HAVING count(*) > 1
ORDER BY user_id, product_id desc;

-- 서울에 위치한 식당 목록 출력하기 --
SELECT ri.rest_id, ri.rest_name, ri.food_type, ri.favorites, ri.address, ROUND(score, 2) as score
FROM
(
    SELECT rest_id, rest_name, food_type, favorites, address
    FROM rest_info
    WHERE address like '서울%'
) ri
INNER JOIN
(
    SELECT rest_id, AVG(review_score) as score
    FROM rest_review
    GROUP BY rest_id
) rr
ON ri.rest_id = rr.rest_id
ORDER BY rr.score desc, ri.favorites desc;