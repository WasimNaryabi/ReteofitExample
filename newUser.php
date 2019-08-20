<?php

require_once 'connection.php';

class User{

    private $db;
    private $connection;
    function __construct(){

        $this->db = new DB_Connection();
        $this->connection = $this->db->get_connection();

         if(!$this->connection){
	                    echo "not connected ".mysqli_connect_error();
                     }
    
    }

    public function does_user_exist($name,$email,$password,$role)
		{
			$query = "Select * from user where email='$email' and password = '$password' ";
			$result = mysqli_query($this->connection, $query);
			if(mysqli_num_rows($result)>0){
				$json['error'] = $email.' : User already exist go to login';
				echo json_encode($json);
				mysqli_close($this -> connection);
			}else{
				$query = "insert into USER (name,email, password,role) values ( '$name','$email','$password','$role')";
				$inserted = mysqli_query($this -> connection, $query);
				if($inserted == 1 ){
					$json['success'] = 'New user Acount created';
				}else{
					$json['error'] = 'User Not addes Try Again!';
				}
				echo json_encode($json);
				mysqli_close($this->connection);
			}
		}

    
}


$user = new User();
if(isset($_POST['name'],$_POST['email'],$_POST['password'],$_POST['role'])){
    $name = $_POST['name'];  
    $email = $_POST['email'];
    $password = $_POST['password'];
    $role = $_POST['role'];


    if(!empty($email) && !empty($password) && !empty($name) && !empty($email)){
        $user->does_user_exist($name,$email,$password,$role);
    }else{
        echo json_encode("You must fill both fields");
    }
}