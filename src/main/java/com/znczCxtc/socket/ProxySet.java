package com.znczCxtc.socket;

import java.util.Vector;

import com.znczCxtc.socket.SocketProxy;

public class ProxySet {

	private static Vector<SocketProxy> proxys = new Vector<SocketProxy>();
	
	public static void addSocketProxy(SocketProxy proxy){
		proxys.add(proxy);
		System.out.println("proxysSize="+proxys.size());
	}
	
	public static void removeSocketProxy(SocketProxy proxy){
		proxys.remove(proxy);
		System.out.println(proxy.getPlaceFlag()+" 离开了");
		//sayToAllProxy(proxy.getBfNoFlag()+" 离开了", proxy);
		
	}
	
	public static void sayToAllProxy(String mes,SocketProxy sender){
		for(int i=0;i<proxys.size();i++){
			if(proxys.get(i)!=sender){
				proxys.get(i).sayToMe(sender.getPlaceFlag()+":"+mes);
			}
			
		}
	}
	
	public static void sayToClient(String mes,int placeFlag){
		System.out.println("proxys.size()==="+proxys.size());
		for(int i=0;i<proxys.size();i++){
			SocketProxy proxy = proxys.get(i);
			int proxyPlaceFlag = proxy.getPlaceFlag();
			System.out.println("getPlaceFlag==="+proxyPlaceFlag);
			System.out.println("placeFlag==="+placeFlag);
			if(proxyPlaceFlag==placeFlag){
				System.out.println("sayToMemes==="+mes);
				proxys.get(i).sayToMe(mes);
			}
			
		}
	}
}
