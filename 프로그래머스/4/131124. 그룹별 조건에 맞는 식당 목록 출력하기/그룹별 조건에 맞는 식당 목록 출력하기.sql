-- 코드를 입력하세요
SELECT p.MEMBER_NAME, r.REVIEW_TEXT, r.REVIEW_DATE
from MEMBER_PROFILE p
join REST_REVIEW r
on p.MEMBER_ID = r.MEMBER_ID
where r.MEMBER_ID = (select r.MEMBER_ID
                    from REST_REVIEW r
                    group by r.MEMBER_ID
                    order by count(r.MEMBER_ID) desc
                    limit 1)
order by r.REVIEW_DATE, r.REVIEW_TEXT;
                    