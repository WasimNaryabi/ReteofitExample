<?php

class DB_Connection{

    private $connect;

    private $db =   "myjson";                            

    private $host = "localhost";

    private $name = "root";

    private $password = "";

    function __construct(){
        $this->connect = mysqli_connect($this->host,$this->name, $this->password, $this->db);
    }

    public function get_connection(){
        return $this->connect;
    }
}