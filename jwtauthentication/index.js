const express = require('express');
const jwt = require('jsonwebtoken');
const app = express();

/* Creae API route */
app.get('/api', (req, res) => {
    res.json({
        msg: "Welcome to NodeJS JWT Authentication Tutorial"
    });
});


//User signin route 
app.post('/api/signin', (req, res) => {
    const user = {
        id: 1,
        username: "johndoe",
        email: "john.doe@test.com"
    }
    jwt.sign({user},'SuperSecRetKey', (err, token) => {
        res.json({token});
    });
});

/** Create posts protected route */

app.post('/api/posts', verifyToken, (req, res) => {
    jwt.verify(req.token, 'SuperSecRetKey', (err, authData)=>{
        if(err){
            res.sendStatus(403);
        }else{
            res.json({
                msg: "A new post is created",
                authData
            });
        }
    });
});

/** verifyToken method - this method verifies token */
function verifyToken(req, res, next){
    //Request header with authorization key
    const bearerHeader = req.headers['authorization'];
    //Check if there is  a header
    if(typeof bearerHeader !== 'undefined'){
        const bearer = bearerHeader.split(' ');
        //Get Token arrray by spliting
        const bearerToken = bearer[1];
        req.token = bearerToken;
        //call next middleware
        next();
    }else{
        res.sendStatus(403);
    }
}


app.listen(4400, () => console.log(' Server started and listening on port: 4400'));