//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2007-2008 Openbravo, S.L.
//    http://sourceforge.net/projects/openbravopos
//
//    This program is free software; you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation; either version 2 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program; if not, write to the Free Software
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

package com.openbravo.pos.sales;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.List;
import com.openbravo.basic.BasicException;
import com.openbravo.pos.catalog.CatalogSelector;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.catalog.JCatalog;
import com.openbravo.pos.forms.BeanFactoryException;
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.pos.forms.DataLogicSystem;

public class JTicketCatalogLines extends javax.swing.JPanel {
    
    private JRefundLines m_reflines;
    private CatalogSelector m_catalog;
    
    /** Creates new form JTicketCatalogLines */
    public JTicketCatalogLines(AppView app, JPanelTicketEdits jTicketEdit) {
        
        DataLogicSystem dlSystem = null;
        DataLogicSales dlSales = null;
        dlSystem = (DataLogicSystem) app.getBean("com.openbravo.pos.forms.DataLogicSystemCreate");
        dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSalesCreate");
        
        initComponents();
        
        m_reflines = new JRefundLines(dlSystem, jTicketEdit);        
        add(m_reflines, "reflines");
        
        m_catalog = new JCatalog(dlSales);
        // m_catalog.addActionListener(new CatalogListener());        
        add(m_catalog.getComponent(), "catalog");
    }
    
    public void showCatalog() {
        showView("catalog");
    }
    
    public void loadCatalog() throws BasicException {
        m_catalog.loadCatalog();
    }
    
    public void addActionListener(ActionListener l) {
        m_catalog.addActionListener(l);
    }
    public void removeActionListener(ActionListener l) {
        m_catalog.addActionListener(l);
    }
    
    public void showRefundLines(List aRefundLines) {
        // anado las lineas de refund
        m_reflines.setLines(aRefundLines);
        showView("reflines");
    }   
    
    private void showView(String sView) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, sView);       
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.CardLayout());

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
