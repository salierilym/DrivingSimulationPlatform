<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24">
        <blockquote class="text-warning" style="font-size: 14px">
          <h2 class="text-danger">
            尊敬的用户您好，欢迎使用TJRD驾驶仿真综合服务平台！
          </h2>
          浏览TJRD课题组网站
          <br />
          <el-link
            href="https://tjrd.tongji.edu.cn/"
            type="primary"
            target="_blank"
            >https://tjrd.tongji.edu.cn/</el-link
          >
          <br />
          <br />
          浏览此平台开发者个人博客
          <br />
          <el-link
            href="https://heylym.com/"
            type="primary"
            target="_blank"
            >https://heylym.com/</el-link
          >
          <br />
        </blockquote>

        <hr />
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>TJRD驾驶仿真综合服务平台</h2>
        <p>
          针对既有的传统模拟驾驶仿真系统存在的局限性，本平台旨在提供无插件、跨平台、轻量化、高拓展性的驾驶仿真辅助技术服务。基于Unreal Engine 4引擎交互式视景仿真开发技术，实现模拟驾驶与车道级真实交通流场景协同仿真、模拟驾驶过程中行车环境解析与优化等多项创新性功能服务模块，并提供驾驶仿真信息数据服务接口，实现不同类型信息流的实时采集、处理与推送，实现基于Web的新一代轻量化开源驾驶实验与辅助评估设计平台。        </p>
        <p>
          <b>当前版本:</b> <span>v{{ version }}</span>
        </p>
        <p>
          <el-tag type="danger">本平台尚处于初步开发阶段，如存在缺陷还请您谅解。</el-tag>
        </p>
        <p>
          <el-button
            size="mini"
            icon="el-icon-s-home"
            plain
            @click="goTarget('https://github.com/salierilym/DrivingSimulationPlatform')"
            >访问Github</el-button
          >
        </p>
      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-row>
          <el-col :span="12">
            <h2>技术选型</h2>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <h4>后端技术</h4>
            <ul>
              <li>SpringBoot</li>
              <li>Spring Security</li>
              <li>JWT</li>
              <li>MyBatis</li>
              <li>Druid</li>
              <li>Fastjson</li>
              <li>...</li>
            </ul>
          </el-col>
          <el-col :span="6">
            <h4>前端技术</h4>
            <ul>
              <li>Vue</li>
              <li>Vuex</li>
              <li>Element-ui</li>
              <li>Axios</li>
              <li>Sass</li>
              <li>Quill</li>
              <li>...</li>
            </ul>
          </el-col>
          <el-col :span="6">
            <h4>驾驶仿真技术</h4>
            <ul>
              <li>Unreal Engine 4</li>
              <li>Airsim</li>
              <li>...</li>
            </ul>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>联系信息</span>
          </div>
          <div class="body">
            <p>
              <i class="el-icon-s-promotion"></i> 个人博客：<el-link
                href="https://heylym.com/"
                target="_blank"
                >https://heylym.com/</el-link
              >
            </p>
            <p>
              <i class="el-icon-user-solid"></i> QQ：
              920337765
            </p>
            <p>
              <i class="el-icon-chat-dot-round"></i> 微信：<a
                href="javascript:;"
                >。。。</a
              >
            </p>
            <p>
              <i class="el-icon-money"></i> 支付宝：<a
                href="javascript:;"
                class="支付宝信息"
                >。。。</a
              >
            </p>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>现有功能</span>
          </div>
          <el-collapse accordion>
            <el-collapse-item title="基于像素流送的在线模拟驾驶">
              在Unreal Engine 4引擎中构建高逼真度的驾驶视景仿真道路环境，并集成模拟驾驶软件模块，能够支持使用仿真车辆进行模拟驾驶以及通过脚本控制车辆行驶。并设置轴属性映射，能够与实验室硬件设备（例如罗技G29）相集成，再通过直接点对点连接将视频流送发送到Web平台。
            </el-collapse-item>
            <el-collapse-item title="模拟驾驶与车道级真实交通流场景再现协同仿真">
              基于已有的自然驾驶环境下的真实交通流数据，开发交通流场景再现仿真模块，能够在车道、车型、车速、车辆行驶路径等层面上设置与真实客观环境相符的交通流量，并实现寻路、感知、环境查询、构建AI行为树决策流程等，实现与真实交通流相适应的行驶车辆的仿真驱动，做到模拟驾驶与真实交通流的协同仿真。
            </el-collapse-item>
            <el-collapse-item title="驾驶仿真信息数据采集、展示与导出">
              通过将虚幻引擎的驾驶仿真实验与数据库连接，实现了驾驶实验数据的传输、展示与修改，并进一步提供驾驶仿真信息数据服务。
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>广告位招商</span>
          </div>
          <div class="body">
            我实在不知道还能放什么东西了
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      // 版本号
      version: "1.0.0",
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

