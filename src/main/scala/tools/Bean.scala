package tools

import java.beans.*
import java.io.Serializable

trait Bean extends Serializable:
    val serialVersionUID = 1L
    @transient var mPcs: PropertyChangeSupport = new PropertyChangeSupport(this)
    @transient var mVcs: VetoableChangeSupport = new VetoableChangeSupport(this)

    def initSupport(): Unit =
        if (mPcs == null) mPcs = new PropertyChangeSupport(this)
        if (mVcs == null) mVcs = new VetoableChangeSupport(this)
        
    def fireVetoableChange(propertyName: String, oldValue: Any, newValue: Any): Unit =
        mVcs.fireVetoableChange(propertyName, oldValue, newValue)
    
    def firePropertyChange(propertyName: String, oldValue: Any, newValue: Any): Unit =
        mPcs.firePropertyChange(propertyName, oldValue, newValue)
    
    def addPropertyChangeListener(listener: PropertyChangeListener): Unit =
        mPcs.addPropertyChangeListener(listener)
    
    def removePropertyChangeListener(listener: PropertyChangeListener): Unit =
        mPcs.removePropertyChangeListener(listener);
    
    def addVetoableChangeListener(listener: VetoableChangeListener): Unit =
        mVcs.addVetoableChangeListener(listener);
    
    def removeVetoableChangeListener(listener: VetoableChangeListener): Unit =
        mVcs.removeVetoableChangeListener(listener);