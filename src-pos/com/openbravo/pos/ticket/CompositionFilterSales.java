//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2008 Open Sistemas de Información Internet, S.L.
//    http://www.opensistemas.com
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

package com.openbravo.pos.ticket;

import java.util.List;
import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.ComboBoxValModel;
import com.openbravo.data.gui.ListQBFModelNumber;
import com.openbravo.data.loader.QBFCompareEnum;
import com.openbravo.data.loader.SentenceList;
import com.openbravo.data.user.EditorCreator;
import com.openbravo.editor.JEditorKeys;
import com.openbravo.editor.JEditorString;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.DataLogicSales;

/**
 *
 * @author  Luis Ig. Bacas Riveiro	lbacas@opensistemas.com
 * @author  Pablo J. Urbano Santos	purbano@opensistemas.com
 */
public class CompositionFilterSales extends javax.swing.JPanel implements EditorCreator {
    
    private SentenceList m_sentcat;
    private ComboBoxValModel m_CategoryModel;
    
    /** Creates new form ProductFilterSales */
    public CompositionFilterSales(DataLogicSales dlSales, JEditorKeys jKeys) {
        initComponents();
        
        // El modelo de categorias
        m_sentcat = dlSales.getCategoriesList();
        m_CategoryModel = new ComboBoxValModel();           
        
        m_jCboPriceSell.setModel(ListQBFModelNumber.getMandatoryNumber());
        m_jPriceSell.addEditorKeys(jKeys);
        
        m_jtxtName.addEditorKeys(jKeys);
        
        m_jtxtBarCode.addEditorKeys(jKeys);
    }
    
    public void activate() {
        m_jtxtBarCode.reset();
        m_jtxtBarCode.setEditModeEnum(JEditorString.MODE_123);
        m_jtxtName.reset();
        m_jPriceSell.reset();
        m_jtxtName.activate();
    }
    
    public Object createValue() throws BasicException {
        
        Object[] afilter = new Object[6];
        
        // Nombre
        if (m_jtxtName.getText() == null || m_jtxtName.getText().equals("")) {
            afilter[0] = QBFCompareEnum.COMP_NONE;
            afilter[1] = null;
        } else {
            afilter[0] = QBFCompareEnum.COMP_RE;
            afilter[1] = "%" + m_jtxtName.getText() + "%";
        }
        
        // Precio de venta
        try {
            afilter[2] = m_jCboPriceSell.getSelectedItem();
            afilter[3] =  new Double(m_jPriceSell.getValueInteger());
        } catch (BasicException e) {
            afilter[2] = QBFCompareEnum.COMP_NONE;
            afilter[3] = null;
        }
   
        // el codigo de barras
        if (m_jtxtBarCode.getText() == null || m_jtxtBarCode.getText().equals("")) {
            afilter[4] = QBFCompareEnum.COMP_NONE;
            afilter[5] = null;
        } else{
            afilter[4] = QBFCompareEnum.COMP_RE;
            afilter[5] = "%" + m_jtxtBarCode.getText() + "%";
        }
        
        return afilter;
    } 
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        m_jtxtName = new com.openbravo.editor.JEditorString();
        jLabel3 = new javax.swing.JLabel();
        m_jCboPriceSell = new javax.swing.JComboBox();
        m_jPriceSell = new com.openbravo.editor.JEditorCurrency();
        m_jtxtBarCode = new com.openbravo.editor.JEditorString();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(370, 170));
        setLayout(null);

        jLabel5.setText(AppLocal.getIntString("label.prodname")); // NOI18N
        add(jLabel5);
        jLabel5.setBounds(20, 40, 110, 25);
        add(m_jtxtName);
        m_jtxtName.setBounds(130, 40, 290, 25);

        jLabel3.setText(AppLocal.getIntString("label.prodpricesell")); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(20, 70, 110, 25);
        add(m_jCboPriceSell);
        m_jCboPriceSell.setBounds(130, 70, 150, 25);
        add(m_jPriceSell);
        m_jPriceSell.setBounds(290, 70, 130, 25);
        add(m_jtxtBarCode);
        m_jtxtBarCode.setBounds(130, 10, 290, 25);

        jLabel1.setText(AppLocal.getIntString("label.prodbarcode")); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(20, 10, 110, 25);
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox m_jCboPriceSell;
    private com.openbravo.editor.JEditorCurrency m_jPriceSell;
    private com.openbravo.editor.JEditorString m_jtxtBarCode;
    private com.openbravo.editor.JEditorString m_jtxtName;
    // End of variables declaration//GEN-END:variables
    
}
