package org.bigbluebutton.api.messaging;

import java.util.HashMap;

import org.bigbluebutton.api.messaging.converters.messages.CreateMeetingMessage;
import org.bigbluebutton.api.messaging.converters.messages.DestroyMeetingMessage;
import org.bigbluebutton.api.messaging.converters.messages.EndMeetingMessage;
import org.bigbluebutton.api.messaging.converters.messages.KeepAliveMessage;
import org.bigbluebutton.api.messaging.converters.messages.PublishRecordingMessage;
import org.bigbluebutton.api.messaging.converters.messages.UnpublishRecordingMessage;
import org.bigbluebutton.api.messaging.converters.messages.DeleteRecordingMessage;

public class MessageToJson {


	
	public static String createMeetingMessageToJson(CreateMeetingMessage msg) {
		HashMap<String, Object> payload = new HashMap<String, Object>();
		payload.put(Constants.MEETING_ID, msg.id);
		payload.put(Constants.EXTERNAL_MEETING_ID, msg.externalId);
		payload.put(Constants.NAME, msg.name);
		payload.put(Constants.RECORDED, msg.record);
		payload.put(Constants.VOICE_CONF, msg.voiceBridge);
		payload.put(Constants.DURATION, msg.duration);
		payload.put(Constants.AUTO_START_RECORDING, msg.autoStartRecording);
		payload.put(Constants.ALLOW_START_STOP_RECORDING, msg.allowStartStopRecording);
		payload.put(Constants.WEBCAMS_ONLY_FOR_MODERTOR, msg.webcamsOnlyForModerator);
		payload.put(Constants.MODERATOR_PASS, msg.moderatorPass);
		payload.put(Constants.VIEWER_PASS, msg.viewerPass);
		payload.put(Constants.CREATE_TIME, msg.createTime);
		payload.put(Constants.CREATE_DATE, msg.createDate);
		payload.put(Constants.METADATA, msg.metadata);
		
		java.util.HashMap<String, Object> header = MessageBuilder.buildHeader(CreateMeetingMessage.CREATE_MEETING_REQUEST_EVENT, CreateMeetingMessage.VERSION, null);
		return MessageBuilder.buildJson(header, payload);				
	}
	
	public static String destroyMeetingMessageToJson(DestroyMeetingMessage msg) {
		HashMap<String, Object> payload = new HashMap<String, Object>();
		payload.put(Constants.MEETING_ID, msg.meetingId);
		
		java.util.HashMap<String, Object> header = MessageBuilder.buildHeader(DestroyMeetingMessage.DESTROY_MEETING_REQUEST_EVENT, DestroyMeetingMessage.VERSION, null);
		return MessageBuilder.buildJson(header, payload);				
	}	
	
	public static String endMeetingMessageToJson(EndMeetingMessage msg) {
		HashMap<String, Object> payload = new HashMap<String, Object>();
		payload.put(Constants.MEETING_ID, msg.meetingId);
		
		java.util.HashMap<String, Object> header = MessageBuilder.buildHeader(EndMeetingMessage.END_MEETING_REQUEST_EVENT, EndMeetingMessage.VERSION, null);
		return MessageBuilder.buildJson(header, payload);				
	}	

	public static String keepAliveMessageToJson(KeepAliveMessage msg) {
		HashMap<String, Object> payload = new HashMap<String, Object>();
		payload.put(Constants.KEEP_ALIVE_ID, msg.keepAliveId);
		
		java.util.HashMap<String, Object> header = MessageBuilder.buildHeader(KeepAliveMessage.KEEP_ALIVE_REQUEST, KeepAliveMessage.VERSION, null);
		return MessageBuilder.buildJson(header, payload);				
	}	
	
	public static String publishRecordingMessageToJson(PublishRecordingMessage message) {
		HashMap<String, Object> payload = new HashMap<String, Object>();
		payload.put(Constants.RECORD_ID, message.recordId);
		payload.put(Constants.MEETING_ID, message.meetingId);
		payload.put(Constants.EXTERNAL_MEETING_ID, message.externalMeetingId);
		payload.put(Constants.FORMAT, message.format);

		java.util.HashMap<String, Object> header = MessageBuilder.buildHeader(PublishRecordingMessage.PUBLISH_RECORDING, PublishRecordingMessage.VERSION, null);
		return MessageBuilder.buildJson(header, payload);
	}

	public static String unpublishRecordingMessageToJson(UnpublishRecordingMessage message) {
		HashMap<String, Object> payload = new HashMap<String, Object>();
		payload.put(Constants.RECORD_ID, message.recordId);
		payload.put(Constants.MEETING_ID, message.meetingId);
		payload.put(Constants.EXTERNAL_MEETING_ID, message.externalMeetingId);
		payload.put(Constants.FORMAT, message.format);

		java.util.HashMap<String, Object> header = MessageBuilder.buildHeader(UnpublishRecordingMessage.UNPUBLISH_RECORDING, UnpublishRecordingMessage.VERSION, null);
		return MessageBuilder.buildJson(header, payload);
	}

	public static String deleteRecordingMessageToJson(DeleteRecordingMessage message) {
		HashMap<String, Object> payload = new HashMap<String, Object>();
		payload.put(Constants.RECORD_ID, message.recordId);
		payload.put(Constants.MEETING_ID, message.meetingId);
		payload.put(Constants.EXTERNAL_MEETING_ID, message.externalMeetingId);
		payload.put(Constants.FORMAT, message.format);

		java.util.HashMap<String, Object> header = MessageBuilder.buildHeader(DeleteRecordingMessage.DELETE_RECORDING, DeleteRecordingMessage.VERSION, null);
		return MessageBuilder.buildJson(header, payload);
	}
	
}
