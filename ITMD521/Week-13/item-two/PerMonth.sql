select p.cs_uri_stem, p.date_month from
(
select count(cs_uri_stem), cs_uri_stem
from logs
where sc_status="200"
AND cs_uri_stem NOT LIKE 'index%'
group by date_month, cs_uri_stem
) as p
group by date_month;