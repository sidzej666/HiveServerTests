Given a playerDto
And name set to $name
And email set to $email
When I create a player
Then an error $message should be shown in response
And an http $code should appear in the response

Examples:
|name|email|message|code|
aaa|aaa@email.com|error|404|