/**
 * Copyright 2016 Areeb Beigh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.areebbeigh.qrcodeutility.fragments.inputfragments;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.areebbeigh.qrcodeutility.R;
import com.areebbeigh.qrcodeutility.generator.QRCode;

public class URLInputFragment extends BaseInputFragment {

    @Override
    public int getViewLayout() {
        return R.layout.input_url;
    }

    @Override
    public Button.OnClickListener getCreateButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = ((EditText) findViewById(R.id.url)).getText().toString();

                if (url.equals("")) {
                    Toast.makeText(getActivity(), "Empty URL", Toast.LENGTH_LONG).show();
                    return;
                }

                if (!(url.startsWith("http://") || url.startsWith("https://")))
                    url = "http://" + url;

                QRCode qrCode = new QRCode(url);
                showQRCode(qrCode);
            }
        };
    }
}
