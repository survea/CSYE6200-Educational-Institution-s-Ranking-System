/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.course.Course;
import model.university.University;

/**
 *
 * @author dhairyasheel
 */
public class CourseUpdateJPanel1 extends javax.swing.JPanel {

    /**
     * Creates new form CoursesJPanel
     */
    private JPanel mainWorkArea;
    private University university;
    private Course course;
    public CourseUpdateJPanel1(JPanel mainWorkArea,University university,Course course) {
        initComponents();
        this.mainWorkArea = mainWorkArea;
        this.university = university;
        this.course =course;
        
       txtCourseCode.setText(course.getCourseCode());
       txtCourseName.setText(course.getCourseName());
       txtDesc.setText(course.getCourseDescription());
       txtKeyword.setText(String.valueOf(course.getCourseContentList()));
       txtCredits.setText(String.valueOf(course.getCredits()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        addjPanel3 = new javax.swing.JPanel();
        lblCourseCode = new javax.swing.JLabel();
        txtCourseCode = new javax.swing.JTextField();
        lblCourseName = new javax.swing.JLabel();
        txtCourseName = new javax.swing.JTextField();
        lblkeywords = new javax.swing.JLabel();
        lblCredits = new javax.swing.JLabel();
        txtCredits = new javax.swing.JTextField();
        lblDesc = new javax.swing.JLabel();
        txtKeyword = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        btnSubmit = new javax.swing.JButton();

        setBackground(new java.awt.Color(254, 254, 254));

        lblTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(78, 105, 151));
        lblTitle.setText("Update Course Structure");

        btnBack.setBackground(new java.awt.Color(254, 254, 254));
        btnBack.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnBack.setForeground(new java.awt.Color(100, 149, 162));
        btnBack.setText("Back");
        btnBack.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        addjPanel3.setBackground(new java.awt.Color(254, 254, 254));
        addjPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Course Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 15), new java.awt.Color(95, 139, 162))); // NOI18N

        lblCourseCode.setBackground(new java.awt.Color(254, 254, 254));
        lblCourseCode.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblCourseCode.setForeground(new java.awt.Color(114, 150, 180));
        lblCourseCode.setText("Course Code:");

        txtCourseCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseCodeActionPerformed(evt);
            }
        });

        lblCourseName.setBackground(new java.awt.Color(254, 254, 254));
        lblCourseName.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblCourseName.setForeground(new java.awt.Color(114, 150, 180));
        lblCourseName.setText("Course Name:");

        lblkeywords.setBackground(new java.awt.Color(254, 254, 254));
        lblkeywords.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblkeywords.setForeground(new java.awt.Color(114, 150, 180));
        lblkeywords.setText("Keywords:");

        lblCredits.setBackground(new java.awt.Color(254, 254, 254));
        lblCredits.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblCredits.setForeground(new java.awt.Color(114, 150, 180));
        lblCredits.setText("Credits:");

        lblDesc.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblDesc.setForeground(new java.awt.Color(99, 119, 145));
        lblDesc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesc.setText("Description:");

        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        jScrollPane3.setViewportView(txtDesc);

        javax.swing.GroupLayout addjPanel3Layout = new javax.swing.GroupLayout(addjPanel3);
        addjPanel3.setLayout(addjPanel3Layout);
        addjPanel3Layout.setHorizontalGroup(
            addjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addjPanel3Layout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addGroup(addjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDesc)
                    .addComponent(lblkeywords)
                    .addComponent(lblCourseName)
                    .addComponent(lblCredits)
                    .addComponent(lblCourseCode))
                .addGap(18, 18, 18)
                .addGroup(addjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(txtCredits)
                    .addComponent(txtKeyword)
                    .addComponent(txtCourseName)
                    .addComponent(txtCourseCode))
                .addGap(204, 204, 204))
        );
        addjPanel3Layout.setVerticalGroup(
            addjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addjPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCourseCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCourseName)
                    .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblkeywords)
                    .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCredits)
                    .addComponent(txtCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesc)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        btnSubmit.setBackground(new java.awt.Color(254, 254, 254));
        btnSubmit.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(100, 149, 162));
        btnSubmit.setText("Submit");
        btnSubmit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addjPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(369, 369, 369))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(419, 419, 419)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(addjPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        backMethod();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtCourseCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCourseCodeActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        if(txtCourseCode.getText().isEmpty() | txtKeyword.getText().isEmpty()|txtCourseName.getText().isEmpty()|txtCredits.getText().isEmpty()|txtDesc.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fillup all the fields","Error",JOptionPane.ERROR_MESSAGE);  
        } else {
            int credit;
            try{
                credit = Integer.parseInt(txtCredits.getText());
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Please enter credits in integer","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            course.setCourseCode(txtCourseCode.getText());
            course.setCourseName(txtCourseName.getText());
            course.setCredits(credit);
            course.setCourseDescription(txtDesc.getText());
            JOptionPane.showMessageDialog(this, "Updated Course Information","Success",JOptionPane.INFORMATION_MESSAGE);  
            backMethod();
        }
        
    }//GEN-LAST:event_btnSubmitActionPerformed
private void backMethod() {
        DepartmentJPanel courseJPanel = new DepartmentJPanel(mainWorkArea,university,"admin");
       mainWorkArea.add("DepartmentJPanel", courseJPanel);
       CardLayout layout = (CardLayout) mainWorkArea.getLayout();
       layout.next(mainWorkArea);
         }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addjPanel3;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCourseCode;
    private javax.swing.JLabel lblCourseName;
    private javax.swing.JLabel lblCredits;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblkeywords;
    private javax.swing.JTextField txtCourseCode;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtCredits;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables
}
