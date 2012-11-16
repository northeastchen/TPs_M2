package fr.istic.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FirstGWT implements EntryPoint {
	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private final Messages messages = GWT.create(Messages.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button sendButton = new Button(messages.sendButton());
		final TextBox nameField = new TextBox();
		nameField.setText(messages.nameField());

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get();
		rootPanel.add(nameField);
		RootPanel.get().add(sendButton);

		Button michel = new Button("New button");
		rootPanel.add(michel, 100, 84);

		Button btnJeanmichel = new Button("Jean-Michel");
		rootPanel.add(btnJeanmichel, 69, 155);

		Button btnJeanmichel_1 = new Button("Jean-Michel");
		rootPanel.add(btnJeanmichel_1, 183, 27);

		sendButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {

				greetingService.greetServer(nameField.getText(),
						new AsyncCallback<String>() {

							public void onSuccess(String result) {
								Window.alert("server dit " + result);
							}

							public void onFailure(Throwable caught) {
								Window.alert("erreur " + caught.getMessage());

							}
						});

			}
		});

	}
}
