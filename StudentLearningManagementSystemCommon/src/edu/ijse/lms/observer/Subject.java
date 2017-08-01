/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Pahansith
 * @param <T>
 */
public interface Subject<T> extends Remote{
    public void registerObserver(T observer) throws RemoteException;
    
    public void unregisterObserver(T observer) throws RemoteException;
    
    public void registerSpecificObserver(T observer,Object identifier) throws RemoteException;
    
    public void unregisterSpecificObserver(T observer,Object identifier) throws RemoteException;
    
    public void notifyAllObservers(Object anObject)throws RemoteException;
    
    public void notifySpecificObservers(Object anObject,Object identifier)throws RemoteException;
}
