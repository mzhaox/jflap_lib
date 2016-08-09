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

package edu.duke.cs.jflap.gui.editor;

import edu.duke.cs.jflap.automata.State;
import edu.duke.cs.jflap.automata.Transition;
import edu.duke.cs.jflap.automata.mealy.MooreTransition;
import edu.duke.cs.jflap.gui.viewer.AutomatonPane;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * This is a transition creator for Moore machines.
 *
 * @author Jinghui Lim
 *
 */
public class MooreTransitionCreator extends MealyTransitionCreator {
    /**
     * Column title.
     */
    private static final String NAME = "Label";

    /**
     * Instantiates a new transition creator.
     *
     * @param parent
     *            the parent object that any dialogs or windows brought up by
     *            this creator should be the child of
     */
    public MooreTransitionCreator(AutomatonPane parent) {
        super(parent);
    }

    /**
     * Initializes an empty transition.
     *
     * @param from
     *            the from state
     * @param to
     *            the to state
     */
    @Override
    protected Transition initTransition(State from, State to) {
        return new MooreTransition(from, to, "");
    }

    /**
     * Creates a new table model.
     *
     * @param transition
     *            the transition to create the model for
     */
    @Override
    protected TableModel createModel(Transition transition) {
        final MooreTransition t = (MooreTransition) transition;
        return new AbstractTableModel() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;
            String s[] = new String[] { t.getLabel() };

            @Override
            public Object getValueAt(int r, int c) {
                return s[c];
            }

            @Override
            public void setValueAt(Object o, int r, int c) {
                s[c] = (String) o;
            }

            @Override
            public boolean isCellEditable(int r, int c) {
                return true;
            }

            @Override
            public int getRowCount() {
                return 1;
            }

            @Override
            public int getColumnCount() {
                return 1;
            }

            @Override
            public String getColumnName(int c) {
                return NAME;
            }
        };
    }

    /**
     * Modifies a transition according to what is in the table.
     *
     * @param transition
     *            transition to modify
     * @param model
     *            table to get information from
     */
    @Override
    public Transition modifyTransition(Transition transition, TableModel model) {
        String label = (String) model.getValueAt(0, 0);
        MooreTransition t = (MooreTransition) transition;
        try {
            return new MooreTransition(t.getFromState(), t.getToState(), label);
        } catch (IllegalArgumentException e) {
            reportException(e);
            return null;
        }
    }
}
