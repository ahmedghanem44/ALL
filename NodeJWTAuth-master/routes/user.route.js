const express = require('express');
const router = express.Router();
const mongoose = require('mongoose');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const User = require('../models/user.model');

//it tries to hash the incoming request’s password property. 
//If it fails to do so then returns a response with an error in json format. 
//If it success then it will create a new user and add that to the MongoDB database. 
router.post('/signup', function(req, res) {
   var saltRounds = 0;
   console.log(req.body);
   bcrypt.hash(req.body.password, saltRounds, function(err, hash){
      if(err) {
         return res.status(500).json({
            error: err
         });
      }
      else {
         const user = new User({
            email: req.body.email,
            password: hash    
         });
         user.save().then(function(result) {
            console.log(result);
            res.status(200).json({
               success: 'New user has been created'
            });
         }).catch(error => {
            res.status(500).json({
               error: err
            });
         });
      }
   });
});
//check if the user’s email exists or not. 
//If not then return 401 unauthorized access. 
//If email is there then check the password with bcrypted database password 
//if match found then welcome to the JWT auth else 401 unauthorized access.
router.post('/signin', function(req, res){
   User.findOne({email: req.body.email})
   .then(function(user) {
      bcrypt.compare(req.body.password, user.password, function(err, result){
         if(err) {
            return res.status(401).json({
               failed: 'Unauthorized Access'
            });
         }
         //If the user’s credentials email and password are valid then in response, we need to return a JWT token. 
         //So let us generate the token and return to the user.
         if(result) {
            const JWTToken = jwt.sign({
               email: user.email,
               _id: user._id
            },
            'secret'
            );
            return res.status(200).json({
               success: 'Welcome to the JWT Auth',
               token: JWTToken
            });
         }
         return res.status(401).json({
            failed: 'Unauthorized Access'
         });
      });
   })
   .catch(error => {
      res.status(500).json({
         error: error
      });
   });;
});

/** Create posts protected route */
//To create a post, the user needs to be authenticated first. A token is sent to post create route. 
//Pass verifyToken method as the second argument. 
//In jwt.verify method accepts a token from req.token and same secret key. 
//In the callback method err, and authData parameters are passed. If there is an error, status 403 is sent back. 
//Otherwise, a new post is created and the message with authData is sent to the client.
router.post('/posts', verifyToken, (req, res) => {
   jwt.verify(req.token, 'secret', (err, authData)=>{
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

router.put('/update/:id', (req, res) => {
         User.findByIdAndUpdate(req.params.id, req.body, function(err, user) {
            if (err)
                res.send(err);
            res.json(user);
        });
});

/** verifyToken method - this method verifies token */
//Verify token method is added to authenticate token. 
//This method accepts, req, res and next parameters. 
//The request header’s authorization key contains token and is assigned to a constant bearerHeader.
//Authorization token has a format as bearer <authorizatin_key>. Split the string with space. 
//Token is assigned to a constant bearerHeader. Assign token to req.token. 
//next() middleware method is called. If the header is undefined then a 403 status is returned to the client.
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
   }
   else{
       res.sendStatus(403);
   }
}

module.exports = router;