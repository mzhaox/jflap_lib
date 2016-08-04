/*
*  JFLAP - Formal Languages and Automata Package
*
*
*  Susan H. Rodger
*  Computer Science Department
*  Duke University
*  August 27, 2009

*  Copyright (c) 2002-2009
*  All rights reserved.

*  JFLAP is open source software. Please see the LICENSE for terms.
*
*/

package edu.duke.cs.jflap.gui.action;

import edu.duke.cs.jflap.gui.environment.Environment;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.filechooser.FileFilter;

/**
 * The <CODE>SaveGraphGIFAction</CODE> is an action to save the graph in window
 * to a GIF image file always using a dialog box.
 *
 * @author Jonathan Su, Henry Qin
 */
public class SaveGraphGIFAction extends RestrictedAction {
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  /** The environment that this save action gets it's object from. */
  protected Environment environment;

  protected JMenu myMenu;

  /**
   * Instantiates a new <CODE>SaveGraphGIFAction</CODE>.
   *
   * @param environment
   *            the environment that holds the action
   * @param menu
   *            the JMenu where the action is contained
   */
  public SaveGraphGIFAction(Environment environment, JMenu menu) {
    super("Save Graph as GIF", null);
    this.environment = environment;
    this.myMenu = menu;
  }

  /**
   * Displays JFileChooser for location to save the graph canvas as gif image.
   *
   * @param arg0
   *            the action event
   */
  public void actionPerformed(ActionEvent arg0) {
    Component apane = environment.tabbed.getSelectedComponent();
    JComponent c = (JComponent) environment.getActive();
    SaveGraphUtility.saveGraph(apane, c, "GIF files", "gif");
  }
}

class GIFFileFilter extends FileFilter {
  public boolean accept(File f) {
    return f.getName().endsWith(".gif") || f.isDirectory();
  }

  public String getDescription() {
    return ".gif";
  }
}
