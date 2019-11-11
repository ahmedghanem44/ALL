const http = require('http');
const d = require('./testExport');
const port = 5000;
const server = http.createServer((req,res)=>{

  if (req.url=='/'){
    res.writeHead(200,{"Content-type":"text/html"});
    res.write("This is the homepage");
    res.end();
  }else if(req.url=='/students'){
    res.writeHead(200,{"Content-type":"text/html"});
    res.write("This is the Students page");
    res.end();
  }else if(req.url =='/admin'){
    res.writeHead(401,{"Content-type":"text/html"});
    res.write("Unauthorized page");
    res.end();
  }

})

var cat = require('./cat');
console.log(cat.legs);
cat.sayHello;


console.log(d.dateAndTime);
console.log(new Date().getHours()+":");



server.listen(port,()=>{
  console.log("Server is listening to port number : "+port);
})