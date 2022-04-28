# legal-sight tech challenge

**For local test execution please follow these steps:**

1. To view all speeches <br/>
URL - GET: http://localhost:8081/speech/all

2. To register a new speech <br/>
URL - POST: http://localhost:8081/speech/register <br/> All fields are set to required
```yaml
Sample request body
{
   "speechContent": "This is a speech content",
   "author": "Lincoln",
   "subject": "Speech",
   "createdAt": "2022-04-27 12:00"
}
```

3. To edit a speech <br/>
URL - PUT: http://localhost:8081/speech/edit <br/>
```yaml
Sample request body
{
   "speechId: 1
   "speechContent": "This is a new speech content"
}
```
4. To delete a speech <br/>
URL - DELETE: http://localhost:8081/speech/delete/{speechId} <br/>

5. To search by speechContent, author, subject and date range <br/> All fields are set to optional <br/>
URL - GET: http://localhost:8081/speech/search
```yaml
{
   "speechContent": "keyword",
   "author": "Lincoln",
   "subject": "keyword",
   "startDate": "2022-04-27 12:00",
   "endDate": "2022-04-27 12:30",
}
```
