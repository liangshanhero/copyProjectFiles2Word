package cn.edu.scau.cmi.client;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class CopyFiles2WordSwt {
	private DataBindingContext m_bindingContext;

	protected Shell shell;
	private Label label;
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				try {
					CopyFiles2WordSwt window = new CopyFiles2WordSwt();
					window.open();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("将项目的文本文件复制到一个Word文件中");
		shell.setLayout(new GridLayout(2, false));
		
		label = new Label(shell, SWT.NONE);
		label.setText("请选择项目");
		
		CCombo combo = new CCombo(shell, SWT.BORDER);
		GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 179;
		combo.setLayoutData(gd_combo);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("请选择文件类型");
		new Label(shell, SWT.NONE);
		m_bindingContext = initDataBindings();

	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeSizeLabelObserveWidget = WidgetProperties.size().observe(label);
		IObservableValue sizeShellObserveValue = PojoProperties.value("size").observe(shell);
		bindingContext.bindValue(observeSizeLabelObserveWidget, sizeShellObserveValue, null, null);
		//
		return bindingContext;
	}
}
