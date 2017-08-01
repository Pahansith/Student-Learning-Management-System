/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import edu.ijse.lms.service.impl.ServiceFactoryImpl;

/**
 *
 * @author Pahansith
 */
public class Server {

    
    private ServiceFactoryImpl instance;

    public void startServer() throws RemoteException{
        instance = ServiceFactoryImpl.getInstance();
        Registry registry = LocateRegistry.createRegistry(3450);
        System.out.println("Starting Server....");
        registry.rebind("LMSServer", instance);
    }
    
    public void stopServer() throws RemoteException, NotBoundException, MalformedURLException{
        System.exit(0);
    }
}
