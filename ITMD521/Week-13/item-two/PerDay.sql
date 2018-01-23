select p.cs_uri_stem, p.date_day from
(
select count(cs_uri_stem)
from logs
where sc_status="200"
AND cs_uri_stem NOT LIKE 'index%'
group by date_day, cs_uri_stem
) as p
group by date_day;