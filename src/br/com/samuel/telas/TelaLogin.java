package br.com.samuel.telas;

import java.sql.*;
import br.com.samuel.dao.ModuloConexao;
import java.awt.Color;
import javax.swing.JOptionPane;
// 2

public class TelaLogin extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // metodo logar
    public void logar() {
	String sql = "select * from atbusuario where login=? and senha=?";
	try {
	    pst = conexao.prepareStatement(sql);
	    pst.setString(1, campo1.getText());
	    pst.setString(2, campo2.getText());
	    rs = pst.executeQuery();

	    if (rs.next()) {
		String perfil = rs.getString(6);
		//System.out.println(perfil);
		if (perfil.equals("adim")) {
		    TelaPrincipal telaprincipal = new TelaPrincipal();
		    telaprincipal.setVisible(true);
		    TelaPrincipal.menuRelat.setEnabled(true);
		    TelaPrincipal.cadUsu.setEnabled(true);
		    TelaPrincipal.lblUsuario.setText(rs.getString(2));
		    telaprincipal.lblUsuario.setForeground(Color.red);
		    this.dispose();
		}  else{
		 TelaPrincipal telaprincipal = new TelaPrincipal();
		    telaprincipal.setVisible(true);
		    TelaPrincipal.lblUsuario.setText(rs.getString(2));
		    
		    this.dispose();
		    
		} 
		conexao.close();
	    } else {
		JOptionPane.showMessageDialog(null, "Senha e/ou Usuário inválido (s)");
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, e);
	}
    }

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
	initComponents();
	conexao = ModuloConexao.conector();
	if (conexao != null) {
	    loginSeCon.setText("Conectado");
	} else {
	    loginSeCon.setText("Desconectado");
	}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        loginSeCon = new javax.swing.JLabel();
        campo1 = new javax.swing.JTextField();
        campo2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("System Login S");
        setResizable(false);

        jLabel1.setText("Usuário");

        jLabel2.setText("Senha");

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(loginSeCon, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campo1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(campo2))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginSeCon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(46, 46, 46))
        );

        setSize(new java.awt.Dimension(388, 214));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	logar();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new TelaLogin().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campo1;
    private javax.swing.JPasswordField campo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel loginSeCon;
    // End of variables declaration//GEN-END:variables
}
