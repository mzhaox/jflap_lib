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

package edu.duke.cs.jflap.gui.minimize;

import edu.duke.cs.jflap.gui.TooltipAction;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 * This control panel is a set of GUI elements that, when invoked, call methods
 * on the <CODE>BuilderController</CODE> object.
 *
 * @author Thomas Finley
 */
class BuilderControlPanel extends JToolBar {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new <CODE>BuilderControlPanel</CODE>.
   *
   * @param controller
   *            the builder controller to call methods of
   */
  public BuilderControlPanel(BuilderController controller) {
    initView(this, controller);
  }

  /**
   * Initializes the GUI elements in the indicated toolbar.
   *
   * @param toolbar
   *            the tool bar
   * @param controller
   *            the controller for the building of the automaton
   */
  public static void initView(JToolBar toolbar, final BuilderController controller) {
    toolbar.add(
        new JButton(
            new TooltipAction("Hint", "Adds one transition.") {
              /**
               *
               */
              private static final long serialVersionUID = 1L;

              @Override
              public void actionPerformed(ActionEvent e) {
                controller.hint();
              }
            }));

    toolbar.add(
        new JButton(
            new TooltipAction("Complete", "Adds all transitions.") {
              /**
               *
               */
              private static final long serialVersionUID = 1L;

              @Override
              public void actionPerformed(ActionEvent e) {
                controller.complete();
              }
            }));

    toolbar.add(
        new JButton(
            new TooltipAction("Done?", "Checks if the automaton is done.") {
              /**
               *
               */
              private static final long serialVersionUID = 1L;

              @Override
              public void actionPerformed(ActionEvent e) {
                controller.done();
              }
            }));
  }
}
