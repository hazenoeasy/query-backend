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
