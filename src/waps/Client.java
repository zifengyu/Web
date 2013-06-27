package waps;

import java.util.ArrayList;

public class Client {
	
	public static ArrayList<Client> clientList;
	static {
		clientList = new ArrayList<Client>();
		
		Client client = new Client();
		client.app_id = "c90282fb86da3e10aeac08714f11c329";
		client.udid = "354016055431744";
		client.imsi = "460012150406862";
		client.app_version = "1.0";
		client.sdk_version = "1.8.6";
		client.device_name = "GT-I9100G";
		client.device_brand = "samsung";
		client.y = "e060b8814d2354d4606c8c35fb524bb0";
		client.os_version = "4.0.4";
		client.act = "com.sina.dfh98";
		client.device_width = "480";
		client.device_height = "800";
		clientList.add(client);
		
		client = new Client();
		client.app_id = "442fa37e9ddc8dcd0fea2cc7a3b974bd";
		client.udid = "354016055431744";
		client.imsi = "460012150406862";
		client.app_version = "1.0";
		client.sdk_version = "1.8.6";
		client.device_name = "GT-I9100G";
		client.device_brand = "samsung";
		client.y = "62aa72ad05964429d89420584bafcf9c";
		client.os_version = "4.0.4";
		client.act = "com.sina.dfh98.iceandfire";
		client.device_width = "480";
		client.device_height = "800";
		clientList.add(client);
		
		client = new Client();
		client.app_id = "7f440e08d702650612f0300e8b143309";
		client.udid = "354016055431744";
		client.imsi = "460012150406862";
		client.app_version = "1.0";
		client.sdk_version = "1.8.6";
		client.device_name = "GT-I9100G";
		client.device_brand = "samsung";
		client.y = "eaac9bc88cbe3fa5d1b0cc3b7d88f769";
		client.os_version = "4.0.4";
		client.act = "com.bbpp.shashinshu";
		client.device_width = "480";
		client.device_height = "800";
		clientList.add(client);
		
		client = new Client();
		client.app_id = "1e893136c07aaa5a3babaf8a3f3d26a6";
		client.udid = "354016055431744";
		client.imsi = "460012150406862";
		client.app_version = "1.0";
		client.sdk_version = "1.8.6";
		client.device_name = "GT-I9100G";
		client.device_brand = "samsung";
		client.y = "89b4761ff046857c7a2bf538a84e112f";
		client.os_version = "4.0.4";
		client.act = "com.bbpp.unitconverter";
		client.device_width = "480";
		client.device_height = "800";
		clientList.add(client);
		
		
		client = new Client();
		client.app_id = "c90282fb86da3e10aeac08714f11c329";
		client.udid = "352792040152569";
		client.imsi = "null";
		client.app_version = "1.0";
		client.sdk_version = "1.8.6";
		client.device_name = "XT720";
		client.device_brand = "MOTO_RTEU";
		client.y = "d2ee437c1ad928ce14192101ec9792eb";
		client.os_version = "2.3.7";
		client.act = "com.sina.dfh98";
		client.device_width = "480";
		client.device_height = "800";
		clientList.add(client);
		
		client = new Client();
		client.app_id = "442fa37e9ddc8dcd0fea2cc7a3b974bd";
		client.udid = "352792040152569";
		client.imsi = "null";
		client.app_version = "1.0";
		client.sdk_version = "1.8.6";
		client.device_name = "XT720";
		client.device_brand = "MOTO_RTEU";
		client.y = "07e8f9b3be71dc6d621fe0d818314ed4";
		client.os_version = "2.3.7";
		client.act = "com.sina.dfh98.iceandfire";
		client.device_width = "480";
		client.device_height = "800";
		clientList.add(client);
		
		client = new Client();
		client.app_id = "7f440e08d702650612f0300e8b143309";
		client.udid = "352792040152569";
		client.imsi = "null";
		client.app_version = "1.0";
		client.sdk_version = "1.8.6";
		client.device_name = "XT720";
		client.device_brand = "MOTO_RTEU";
		client.y = "6af78d8a7c1e23e8bf4e6416a17c0c42";
		client.os_version = "2.3.7";
		client.act = "com.bbpp.shashinshu";
		client.device_width = "480";
		client.device_height = "800";
		clientList.add(client);
		
		client = new Client();
		client.app_id = "1e893136c07aaa5a3babaf8a3f3d26a6";
		client.udid = "352792040152569";
		client.imsi = "null";
		client.app_version = "1.0";
		client.sdk_version = "1.8.6";
		client.device_name = "XT720";
		client.device_brand = "MOTO_RTEU";
		client.y = "678a2a23a65b0da9d9d4b8280381c864";
		client.os_version = "2.3.7";
		client.act = "com.bbpp.unitconverter";
		client.device_width = "480";
		client.device_height = "800";
		clientList.add(client);
		
		
	}
	
	public String app_id;
	public String udid;
	public String imsi;	
	public String app_version;
	public String sdk_version;
	public String device_name;
	public String device_brand;
	public String y;
	public String device_type = "android";
	public String os_version;
	public String country_code = "CN";
	public String language = "zh";
	public String act;
	public String channel = "WAPS";
	public String device_width;
	public String device_height;	

}
