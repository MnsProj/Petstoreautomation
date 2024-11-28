package api.endpoints;

/*
swagger uri --> https://petstore.swagger.io/

create user(post) -->https://petstore.swagger.io/v2/user
Get user(Get)	  -->https://petstore.swagger.io/v2/user/{username}
update user(put/patch)-->https://petstore.swagger.io/v2/user/{username}
delete user(Delete)-->https://petstore.swagger.io/v2/user/{username}

*/
public class Routes {

	public static String base_url= "https://petstore.swagger.io/v2";
			
	//user module
			public static String post_user=base_url+"/user";
			public static String get_user=base_url+"/user/{username}";
			public static String put_user=base_url+"/user/{username}";
			public static String delete_user=base_url+"/user/{username}";
	//store module
			public static String post_order=base_url+"/store/order";
			public static String get_order=base_url+"/store/order/{orderId}";
			public static String get_inventory=base_url+"/store/inventory";
			public static String deletes_order=base_url+"/store/order/{orderId}";

	//pet module	
			public static String post_pet=base_url+"/pet";
			public static String get_pet=base_url+"/pet/{petId}";
			public static String put_pet=base_url+"/pet";
			public static String delete_pet=base_url+"/pet/{petId}";
}
