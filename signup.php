<?php
    error_reporting(E_ALL);
    ini_set('display_errors',1);
    
    include('dbconn.php');

    $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");

    if((($_SERVER['REQUEST_METHOD'] == 'POST') && isset($_POST['submit'])) || $android)
    {
        $userEmail = $_POST["userEmail"];
        $userName = $_POST["userName"];
        $userPw = $_POST["userPw"];
        $userGender = $_POST["userGender"];
        $userBirth = $_POST["userBirth"];
        $userHeight = $_POST["userHeight"];

        if(!isset($errMSG)) {
            try {
                $stmt = $conn->prepare('INSERT INTO membertbl(userEmail, userName, userPw, userGender, userBirth, userHeight) VALUES(:userEmail, :userName, :userPw, :userGender, :userBirth, :userHeight)');
                $stmt->bindParam(':userEmail', $userEmail);
                $stmt->bindParam(':userName', $userName);
                $stmt->bindParam(':userPw', $userPw);
                $stmt->bindParam(':userGender', $userGender);
                $stmt->bindParam(':userBirth', $userBirth);
                $stmt->bindParam(':userHeight', $userHeight);

                if($stmt->execute())
                {
                    $successMSG = "success";
                    $response = array();
                    $response["success"] = true;

                    echo json_encode($response);
                }
                else
                {
                    $errMSG = "fail";
                }
            } catch(PDOException $e) {
                die("Database error : ". $e->getMessage());
            }
        }
    }
?>

<?php
    if (isset($errMSG)) echo $errMSG;
    if (isset($successMSG)) echo $successMSG;
 
        $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");
 
    if( !$android )
    {
?>
    <html>
       <body>
            <form action="<?php $_PHP_SELF ?>" method="POST">
                userEmail: <input type = "text" name = "userEmail" />
                userName: <input type = "text" name = "userName" />
                userPw: <input type = "text" name = "userPw" />
                userGender: <input type = "text" name = "userGender" />
                userBirth: <input type = "text" name = "userBirth" />
                userHeight: <input type = "text" name = "userHeight" />
                <input type = "submit" name = "submit" />
            </form>
 
       </body>
    </html>
<?php
    }
?>