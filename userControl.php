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

    public function does_user_exist($email,$password)
		{
			$query = "Select * from user where email='$email' and password = '$password' ";
            $result = mysqli_query($this->connection, $query);
            
			if(mysqli_num_rows($result)>0){
				$json['success'] = ' Welcome '.$email;
				
			}else{
				
					$json['error'] = 'Wrong Email or Password';
                }
                echo json_encode($json);
				mysqli_close($this -> connection);
		}

    
}

$user = new User();
if(isset($_POST['email'],$_POST['password'])){
    $email = $_POST['email'];
    $password = $_POST['password'];

    if(!empty($email) && !empty($password)){
        $user->does_user_exist($email,$password);
    }else{
        echo json_encode("You must fill both fields");
    }
}