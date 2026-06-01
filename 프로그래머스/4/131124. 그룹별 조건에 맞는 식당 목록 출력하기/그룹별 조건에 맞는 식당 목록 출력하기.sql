-- 코드를 입력하세요
SELECT p.MEMBER_NAME, r.REVIEW_TEXT, r.REVIEW_DATE
from MEMBER_PROFILE p
join REST_REVIEW r
on p.MEMBER_ID = r.MEMBER_ID
where r.member_id = (select r.member_id
                     from REST_REVIEW r
                     group by r.member_id
                     order by count(r.member_id) desc
                     limit 1)
order by r.REVIEW_DATE, r.REVIEW_TEXT;
                     