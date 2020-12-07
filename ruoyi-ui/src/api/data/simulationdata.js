import request from '@/utils/request'

// 查询驾驶数据列表
export function listSimulationdata(query) {
  return request({
    url: '/data/simulationdata/list',
    method: 'get',
    params: query
  })
}

// 查询驾驶数据详细
export function getSimulationdata(id) {
  return request({
    url: '/data/simulationdata/' + id,
    method: 'get'
  })
}

// 新增驾驶数据
export function addSimulationdata(data) {
  return request({
    url: '/data/simulationdata',
    method: 'post',
    data: data
  })
}

// 修改驾驶数据
export function updateSimulationdata(data) {
  return request({
    url: '/data/simulationdata',
    method: 'put',
    data: data
  })
}

// 删除驾驶数据
export function delSimulationdata(id) {
  return request({
    url: '/data/simulationdata/' + id,
    method: 'delete'
  })
}

// 导出驾驶数据
export function exportSimulationdata(query) {
  return request({
    url: '/data/simulationdata/export',
    method: 'get',
    params: query
  })
}