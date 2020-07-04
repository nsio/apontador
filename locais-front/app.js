var express = require("express");
var app = express();
var router = express.Router();

var path = __dirname + '/src/app/views';
const PORT = 4000;
const HOST = '127.0.0.1';

router.get("/",function(req,res){
    res.sendFile(path + "/home/home.component.html");
  });
  
  router.get("/cadastro",function(req,res){
    res.sendFile(path + "/cadastro/cadastro.component.html");
  });
  
  router.get("/pesquisa",function(req,res){
    res.sendFile(path + "/pesquisa/pesquisa.component.html");
  });

  //app.use(express.static(__dirname + '/src/assets'));
  //app.use(express.static(__dirname + '/src/app/views/cadastro'));
  //app.use(express.static(__dirname + '/src/app/views/dialog'));
  //app.use(express.static(__dirname + '/src/app/views/home'));
  //app.use(express.static(__dirname + '/src/app/views/pesquisa'));
  app.use(express.static(__dirname + '/dist/locais-front'))
  app.use("/", router);
  
  app.listen(4000, function () {
    console.log('Locais-front rodando na porta 4000')
  })