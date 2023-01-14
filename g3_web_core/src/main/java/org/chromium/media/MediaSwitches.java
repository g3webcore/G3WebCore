// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.media;

/**
 * Contains command line switches that are specific to the media layer.
 */
public abstract class MediaSwitches {
    // Set the autoplay policy to ignore user gesture requirements
    public static final String AUTOPLAY_NO_GESTURE_REQUIRED_POLICY =
            "autoplay-policy=no-user-gesture-required";


    // This following string constants were inserted by
    //     java_cpp_strings.py
    // From
    //     ../../media/base/media_switches.cc
    // Into
    //     ../../media/base/android/java_templates/MediaSwitches.java.tmpl

    // Allow users to specify a custom buffer size for debugging purpose.
    public static final String AUDIO_BUFFER_SIZE = "audio-buffer-size";

    // Set a timeout (in milliseconds) for the audio service to quit if there are no
    // client connections to it. If the value is negative the service never quits.
    public static final String AUDIO_SERVICE_QUIT_TIMEOUT_MS = "audio-service-quit-timeout-ms";

    // Command line flag name to set the autoplay policy.
    public static final String AUTOPLAY_POLICY = "autoplay-policy";


    public static final String DISABLE_AUDIO_OUTPUT = "disable-audio-output";

    // Causes the AudioManager to fail creating audio streams. Used when testing
    // various failure cases.
    public static final String FAIL_AUDIO_STREAM_CREATION = "fail-audio-stream-creation";

    // Set number of threads to use for video decoding.
    public static final String VIDEO_THREADS = "video-threads";

    // Suspend media pipeline on background tabs.
    public static final String ENABLE_MEDIA_SUSPEND = "enable-media-suspend";


    public static final String DISABLE_MEDIA_SUSPEND = "disable-media-suspend";

    // Force to report VP9 as an unsupported MIME type.
    public static final String REPORT_VP9_AS_AN_UNSUPPORTED_MIME_TYPE = "report-vp9-as-an-unsupported-mime-type";

    // The Alsa device to use when opening an audio input stream.
    public static final String ALSA_INPUT_DEVICE = "alsa-input-device";

    // The Alsa device to use when opening an audio stream.
    public static final String ALSA_OUTPUT_DEVICE = "alsa-output-device";

    // Use exclusive mode audio streaming for Windows Vista and higher.
    // Leads to lower latencies for audio streams which uses the
    // AudioParameters::AUDIO_PCM_LOW_LATENCY audio path.
    // See http://msdn.microsoft.com/en-us/library/windows/desktop/dd370844.aspx
    // for details.
    public static final String ENABLE_EXCLUSIVE_AUDIO = "enable-exclusive-audio";

    // Use Windows WaveOut/In audio API even if Core Audio is supported.
    public static final String FORCE_WAVE_AUDIO = "force-wave-audio";

    // Instead of always using the hardware channel layout, check if a driver
    // supports the source channel layout.  Avoids outputting empty channels and
    // permits drivers to enable stereo to multichannel expansion.  Kept behind a
    // flag since some drivers lie about supported layouts and hang when used.  See
    // http://crbug.com/259165 for more details.
    public static final String TRY_SUPPORTED_CHANNEL_LAYOUTS = "try-supported-channel-layouts";

    // Number of buffers to use for WaveOut.
    public static final String WAVE_OUT_BUFFERS = "waveout-buffers";

    // Enables protected buffers for encrypted video streams.
    public static final String ENABLE_PROTECTED_VIDEO_BUFFERS = "enable-protected-video-buffers";

    // Forces protected memory for all output video buffers generated by
    // FuchsiaVideoDecoder, including unencrypted streams. Ignored unless
    // --enable-protected-video-buffers is also specified.
    public static final String FORCE_PROTECTED_VIDEO_OUTPUT_BUFFERS = "force-protected-video-output-buffers";

    // Enables fuchsia.media.AudioConsumer to be used to render audio streams.
    public static final String ENABLE_FUCHSIA_AUDIO_CONSUMER = "enable-fuchsia-audio-consumer";

    // Use CRAS, the ChromeOS audio server.
    public static final String USE_CRAS = "use-cras";

    // For automated testing of protected content, this switch allows specific
    // domains (e.g. example.com) to skip asking the user for permission to share
    // the protected media identifier. In this context, domain does not include the
    // port number. User's content settings will not be affected by enabling this
    // switch.
    // Reference: http://crbug.com/718608
    // Example:
    // --unsafely-allow-protected-media-identifier-for-domain=a.com,b.ca
    public static final String UNSAFELY_ALLOW_PROTECTED_MEDIA_IDENTIFIER_FOR_DOMAIN = "unsafely-allow-protected-media-identifier-for-domain";

    // Use fake device for Media Stream to replace actual camera and microphone.
    // For the list of allowed parameters, see
    // FakeVideoCaptureDeviceFactory::ParseFakeDevicesConfigFromOptionsString().
    public static final String USE_FAKE_DEVICE_FOR_MEDIA_STREAM = "use-fake-device-for-media-stream";

    // Use an .y4m file to play as the webcam. See the comments in
    // media/capture/video/file_video_capture_device.h for more details.
    public static final String USE_FILE_FOR_FAKE_VIDEO_CAPTURE = "use-file-for-fake-video-capture";

    // Play a .wav file as the microphone. Note that for WebRTC calls we'll treat
    // the bits as if they came from the microphone, which means you should disable
    // audio processing (lest your audio file will play back distorted). The input
    // file is converted to suit Chrome's audio buses if necessary, so most sane
    // .wav files should work. You can pass either <path> to play the file looping
    // or <path>%noloop to stop after playing the file to completion.
    public static final String USE_FILE_FOR_FAKE_AUDIO_CAPTURE = "use-file-for-fake-audio-capture";

    // Use a fake device for accelerated decoding of MJPEG. This allows, for
    // example, testing of the communication to the GPU service without requiring
    // actual accelerator hardware to be present.
    public static final String USE_FAKE_MJPEG_DECODE_ACCELERATOR = "use-fake-mjpeg-decode-accelerator";

    // Disable hardware acceleration of mjpeg decode for captured frame, where
    // available.
    public static final String DISABLE_ACCELERATED_MJPEG_DECODE = "disable-accelerated-mjpeg-decode";

    // When running tests on a system without the required hardware or libraries,
    // this flag will cause the tests to fail. Otherwise, they silently succeed.
    public static final String REQUIRE_AUDIO_HARDWARE_FOR_TESTING = "require-audio-hardware-for-testing";

    // Mutes audio sent to the audio device so it is not audible during
    // automated testing.
    public static final String MUTE_AUDIO = "mute-audio";

    // Allows clients to override the threshold for when the media renderer will
    // declare the underflow state for the video stream when audio is present.
    // TODO(dalecurtis): Remove once experiments for http://crbug.com/470940 finish.
    public static final String VIDEO_UNDERFLOW_THRESHOLD_MS = "video-underflow-threshold-ms";

    // Disables the new rendering algorithm for webrtc, which is designed to improve
    // the rendering smoothness.
    public static final String DISABLE_RTC_SMOOTHNESS_ALGORITHM = "disable-rtc-smoothness-algorithm";

    // Force media player using SurfaceView instead of SurfaceTexture on Android.
    public static final String FORCE_VIDEO_OVERLAYS = "force-video-overlays";

    // Allows explicitly specifying MSE audio/video buffer sizes as megabytes.
    // Default values are 150M for video and 12M for audio.
    public static final String MSE_AUDIO_BUFFER_SIZE_LIMIT_MB = "mse-audio-buffer-size-limit-mb";


    public static final String MSE_VIDEO_BUFFER_SIZE_LIMIT_MB = "mse-video-buffer-size-limit-mb";

    // Specifies the path to the Clear Key CDM for testing, which is necessary to
    // support External Clear Key key system when library CDM is enabled. Note that
    // External Clear Key key system support is also controlled by feature
    // kExternalClearKeyForTesting.
    public static final String CLEAR_KEY_CDM_PATH_FOR_TESTING = "clear-key-cdm-path-for-testing";

    // Overrides the default enabled library CDM interface version(s) with the one
    // specified with this switch, which will be the only version enabled. For
    // example, on a build where CDM 8, CDM 9 and CDM 10 are all supported
    // (implemented), but only CDM 8 and CDM 9 are enabled by default:
    //  --override-enabled-cdm-interface-version=8 : Only CDM 8 is enabled
    //  --override-enabled-cdm-interface-version=9 : Only CDM 9 is enabled
    //  --override-enabled-cdm-interface-version=10 : Only CDM 10 is enabled
    //  --override-enabled-cdm-interface-version=11 : No CDM interface is enabled
    // This can be used for local testing and debugging. It can also be used to
    // enable an experimental CDM interface (which is always disabled by default)
    // for testing while it's still in development.
    public static final String OVERRIDE_ENABLED_CDM_INTERFACE_VERSION = "override-enabled-cdm-interface-version";

    // Overrides hardware secure codecs support for testing. If specified, real
    // platform hardware secure codecs check will be skipped. Codecs are separated
    // by comma. Valid codecs are "vp8", "vp9" and "avc1". For example:
    //  --override-hardware-secure-codecs-for-testing=vp8,vp9
    //  --override-hardware-secure-codecs-for-testing=avc1
    // CENC encryption scheme is assumed to be supported for the specified codecs.
    // If no valid codecs specified, no hardware secure codecs are supported. This
    // can be used to disable hardware secure codecs support:
    //  --override-hardware-secure-codecs-for-testing
    public static final String OVERRIDE_HARDWARE_SECURE_CODECS_FOR_TESTING = "override-hardware-secure-codecs-for-testing";

    // Autoplay policy that requires a document user activation.
    public static final String DOCUMENT_USER_ACTIVATION_REQUIRED_POLICY = "document-user-activation-required";

    // Autoplay policy that does not require any user gesture.
    public static final String NO_USER_GESTURE_REQUIRED_POLICY = "no-user-gesture-required";

    // Autoplay policy to require a user gesture in order to play.
    public static final String USER_GESTURE_REQUIRED_POLICY = "user-gesture-required";

    // Prevents instantiation.
    private MediaSwitches() {}
}