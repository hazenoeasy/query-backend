# Structure
`plus.yuhaozhang.blog` is the top package  
`controller` like a waiter, he picked request and get food from services   
`vo` is the menu, it recorded what would return to the customer(frontend)  
`service` is the chief, he handled pojo food from fridge and cooked them like menu. 
`--struct` stores interface , interface is the cooking book, recording the ways chief could do with the food.  
`--implement` is how the chief cook food. He took food from fridge and cooked in specific way.   
`dao` is the fridge.  
``-- TageMapper`` is the courier, he selected food from different storehouse by SQl.  
``-- Pojo`` is the food.

# WorkFlow
1. Define Vo
2. Define Food
3. Consider how to get Food, then define Mapper, write mapper.xml and do operations to the database.
4. define Service struct interface
5. define Service implement
6. define controller

# Bugs
1. every pojo must have @Data, or it couldn't manipulate.

# Re-encapsulate service layer
service was encapsulated, only out put Result type, which would reduce the reuse of services.  
These services could use each other to encapsulate new services.  So I pack the data into Result type at controller layers.

# Using Collection to query data.
```xml
<select id="getTagsNameById" resultType="plus.yuhaozhang.blog.dao.pojo.Tag">
        select * from ms_tag where id in
        <foreach collection="tagIds" item="tagId" separator="," open="(" close=")">
            #{tagId}
        </foreach>
</select>
```
# Transform Data type from BigInt to UNIX_TIME
```sql
select YEAR(FROM_UNIXTIME(create_date/1000,'%Y%m%d')) as year,
MONTH(FROM_UNIXTIME(create_date/1000,'%Y%m%d')) as month,
COUNT(*) as count from ms_article
group by year,month
```
